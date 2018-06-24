(ns email-obfuscator.core-test
  (:require [clojure.test :refer [testing is deftest]]
            [email-obfuscator.core :refer [obfuscate unobfuscate]]))

(deftest test-obfuscate-unobfuscate-funcs
  (testing "Obfuscate e-mail address"
    (is (=
         "svefgrknzcyr.pbz/5" 
         (obfuscate "first@example.com"))))
  (testing "Unobfuscate e-mail address"
    (is (=
         "first@example.com"
         (unobfuscate "svefgrknzcyr.pbz/5")))))
