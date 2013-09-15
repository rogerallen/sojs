# sojs

Simple test of Overtone and ClojureScript

Following this so far...
https://github.com/magomimmo/modern-cljs/blob/master/doc/tutorial-01.md

I'm not much of a web client/server programmer.  I just wanted to give
this a tryout to see what's what.  This is the unfinished, unpolished result.

## Usage

in one shell start the javascript autobuild

    > lein cljsbuild auto

in another shell start the server

    > lein ring server

you should hear overtone bing...and `http://localhost:3000` should pop up.

in another shell, start a repl

    > lein trampoline cljsbuild repl-listen

(the first time, this took a long time to respond.  you may need to reload the simple.html page to get it to work)

in the browser navigate to `http://localhost:3000/play.html`

fill out the form and listen to simple Overtone sounds.

## License

Copyright © 2013 Roger Allen

Distributed under the Eclipse Public License, the same as Clojure.
