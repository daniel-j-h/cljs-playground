(ns cljs-playground.core
  (:require [reagent.core :as r]))

(enable-console-print!)

(defonce app-state
  (r/atom {:items 0}))


(defn mk-button [value on-click]
  [:input {:type "button" :value value :on-click on-click}])

(defn mk-list [items]
  (into
    [:ul]
    (map
      (fn [x] ^{:key x} [:li "Item " x])
      (range items))))


(defn inc-items []
  (swap! app-state update :items inc))

(defn dec-items []
  (swap! app-state update :items (fn [x] (max 0 (dec x)))))


(defn cljs-playground []
  [:center
    (mk-button "More" inc-items)
    (mk-button "Less" dec-items)
    (mk-list (:items @app-state))])



(r/render-component [cljs-playground] (. js/document (getElementById "app")))

(defn on-js-reload []
  (print "State:" @app-state))
