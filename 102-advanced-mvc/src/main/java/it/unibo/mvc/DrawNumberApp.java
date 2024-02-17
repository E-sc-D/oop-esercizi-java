package it.unibo.mvc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 */
public final class DrawNumberApp implements DrawNumberViewObserver {
    private static final String _MIN = "minimum";
    private static final String _MAX = "maximum";
    private static final String _ATTEMPTS = "attempts";
    private final DrawNumber model;
    private final List<DrawNumberView> views;

    /**
     * @param path
     *            the path to the config file
     * @param views
     *            the views to attach
     */
    public DrawNumberApp(String path,final DrawNumberView... views){
        /*
         * Side-effect proof
         */
        Configuration.Builder builder = new Configuration.Builder();
        this.views = Arrays.asList(Arrays.copyOf(views, views.length));
        for (final DrawNumberView view: views) {
            view.setObserver(this);
            view.start();
        }
        try( BufferedReader br = new BufferedReader(
            new InputStreamReader(ClassLoader.getSystemResourceAsStream(path)))){
                for(String s = br.readLine();s!= null;s = br.readLine()){
                    String[] spl = s.split(":");

                    switch (spl[0].toLowerCase()) {
                        case _MIN:
                            builder.setMin(Integer.parseInt(spl[1].trim()));
                            break;
                        case _MAX:
                            builder.setMax(Integer.parseInt(spl[1].trim()));
                            break;
                        case _ATTEMPTS:
                            builder.setAttempts(Integer.parseInt(spl[1].trim()));
                            break;
                        default:
                            throw new IllegalArgumentException(
                                "Config option not recognized, standards are:" 
                                + _MAX + "; " + _MIN + "; " + _ATTEMPTS + 
                                "an example is '" + _MIN + ":10'");
                    }
                }
        } catch (Exception e) {
            sendError(e.getMessage());
        }

        final var conf = builder.build();
        if(conf.isConsistent()){
            this.model = new DrawNumberImpl(conf);
        }     
        else{
            this.model = new DrawNumberImpl(new Configuration.Builder().build());
        }
    }

    @Override
    public void newAttempt(final int n) {
        try {
            final DrawResult result = model.attempt(n);
            for (final DrawNumberView view: views) {
                view.result(result);
            }
        } catch (IllegalArgumentException e) {
            for (final DrawNumberView view: views) {
                view.numberIncorrect();
            }
        }
    }

    public void sendError(String error){
        for (DrawNumberView drawNumberView : views) {
            drawNumberView.displayError(error);
        }
    }

    @Override
    public void resetGame() {
        this.model.reset();
    }

    @Override
    public void quit() {
        /*
         * A bit harsh. A good application should configure the graphics to exit by
         * natural termination when closing is hit. To do things more cleanly, attention
         * should be paid to alive threads, as the application would continue to persist
         * until the last thread terminates.
         */
        System.exit(0);
    }

    /**
     * @param args
     *            ignored
     * @throws FileNotFoundException 
     */
    public static void main(final String... args) throws FileNotFoundException {
        new DrawNumberApp("config.yml",new DrawNumberViewImpl());
    }

}