(ns email-obfuscator.rot13-test
  (:require [clojure.test           :refer [testing is deftest]]
            [email-obfuscator.rot13 :refer [rot13]]))

(deftest test-rot13-func
  (testing "Code string using rot13"
    (is (=
         "uRyyb"
         (rot13 "hEllo"))))
  (testing "Decode string using rot13"
    (is (=
         "hEllo"
         (rot13 "uRyyb"))))
  (testing "Code string with special characters"
    (is (=
         "Gur dhvpx oebja sbk whzcf bire gur ynml qbt."
         (rot13 "The quick brown fox jumps over the lazy dog."))))
  (testing "Decode string with special characters"
    (is (=
         "The quick brown fox jumps over the lazy dog."
         (rot13 "Gur dhvpx oebja sbk whzcf bire gur ynml qbt.")))))
