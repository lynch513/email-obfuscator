(ns email-obfuscator.html-test
  (:require [clojure.test          :refer [deftest is testing]]
            [clojure.java.io       :as io]
            [clojure.string        :as str]
            [email-obfuscator.core :refer [obfuscate]]
            [email-obfuscator.html :refer [as-html-string]]))

(deftest test-as-html-string-func
  (testing "should get string with obfuscated e-mail in html template"
    (let [email "first@example.com"]
      (is (=
          (let [[rot-email index] (-> email
                                      (obfuscate)
                                      (str/split #"\/" 2))]
            (format 
              (slurp (io/resource "template.txt"))
              rot-email
              index
              index))
          (as-html-string email))))))
