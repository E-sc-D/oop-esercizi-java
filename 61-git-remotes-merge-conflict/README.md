# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository( usando semplicemente clone)
2. Ci si assicuri di avere localmente entrambi i branch remoti
( ho visto i branch locali con git branch -v mancava feature, allora con git branch feature origin/feature
è stato importato )
3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`( la testa era gia su master ma in caso git checkout master e poi git merge feature )
4. Si noti che viene generato un **merge conflict**!
5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)
   ( ho visionato e modificato il file e poi committato, con git log --all --graph si vede che il brach si chiude)
6. Si crei un nuovo repository nel proprio github personale
7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote( Ho generato un nuovo remote con remote add other(il nome del remote) e l'url del mio repo, con git remote -v li elenchi)
8. Si faccia push del branch `master` sul proprio repository( git push master other, ho pushato anche feature)
9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale
( git branch -u other/master )
