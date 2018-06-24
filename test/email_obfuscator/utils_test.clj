(ns email-obfuscator.utils-test
  (:require [clojure.test           :refer [testing deftest is]]
            [email-obfuscator.utils :refer [escape-html]]))

(deftest test-escape-html-func
  (testing "Escape html string"
    (is (=
         "&lt;h1&gt;This is test&lt;/h1&gt;"
         (escape-html "<h1>This is test</h1>"))))
  (testing "Escape html string 2"
    (is (=
         "&lt;a href=&quot;example.com&amp;seek_page=1&quot;&gt;&lt;p class=&apos;test&apos;&gt;&lt;/p&gt;&lt;/a&gt;"
         (escape-html 
           "<a href=\"example.com&seek_page=1\"><p class='test'></p></a>")))))
