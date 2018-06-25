(ns email-obfuscator.html
  (:require [clojure.java.io       :as io]
            [email-obfuscator.core :refer [obfuscate]]))

(def html-string-template (slurp (io/resource "template.txt")))

(defn as-html-string
  "Gets email obfuscate it and returns string with javascript for inserting at
  html templates"
  [^String email]
  (let [obfuscated  (obfuscate email)
        slash-index (.lastIndexOf obfuscated "/")
        sb          (StringBuilder. obfuscated)
        rot-email   (.substring sb 0 slash-index)
        index       (Integer/parseInt (.substring sb (inc slash-index)))]
    (format 
      html-string-template
      rot-email
      index
      index)))

