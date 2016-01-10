(defproject cljs-playground "0.0.1"
  :description "ClojureScript + React Playground"
  :url "https://github.com/daniel-j-h/cljs-playground"
  :license {:name "MIT License"
            :url "http://www.opensource.org/licenses/mit-license.php"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [org.clojure/core.async "0.2.374"]
                 [reagent "0.5.0"]]
  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-figwheel "0.5.0-3"]]
  :source-paths ["src"]
  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]
  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src"]
                :figwheel {:on-jsload "cljs-playground.core/on-js-reload"}
                :compiler {:main cljs-playground.core
                           :asset-path "js/compiled/out"
                           :output-to "resources/public/js/compiled/cljs_playground.js"
                           :output-dir "resources/public/js/compiled/out"
                           :source-map-timestamp true}}
               {:id "min"
                :source-paths ["src"]
                :compiler {:output-to "resources/public/js/compiled/cljs_playground.js"
                           :main cljs-playground.core
                           :optimizations :advanced
                           :pretty-print false}}]}
  :figwheel {:server-port 5000
             :css-dirs ["resources/public/css"]})
