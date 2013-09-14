# sojs

Simple test of Overtone and ClojureScript

Following this so far...
https://github.com/magomimmo/modern-cljs/blob/master/doc/tutorial-01.md

## Usage

in one shell start the server
    > lein cljsbuild once
    > lein ring server
you should hear overtone buzzing...and http://localhost:3000 should pop up.

in the browser navigate to http://localhost:3000/simple.html

in another shell, start a repl
    > lein trampoline cljsbuild repl-listen
(the first time, this took a long time to respond.  you may need to reload the simple.html page to get it to work)

## License

Copyright © 2013 Roger Allen

Distributed under the Eclipse Public License, the same as Clojure.
