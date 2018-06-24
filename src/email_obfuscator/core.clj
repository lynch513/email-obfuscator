(ns email-obfuscator.core
  (:require [email-obfuscator.utils :refer [escape-html]]
            [email-obfuscator.rot13 :refer [rot13]]))

(defn obfuscate
  "Gets email as string, removes @ char if exists and only its index is passed on.
  Address itself trasmits as a ROT13 transformed string"
  [^String email]
  (let [esc-email (escape-html email)
        at-index (.indexOf esc-email "@")]
    (if (< at-index 0)
      (rot13 esc-email)
      (-> (StringBuilder. esc-email)
          (.replace at-index (inc at-index) "")
          (rot13)
          (str "/" at-index)))))

(defn unobfuscate
  "Gets obfuscated string and decodes it using ROT13 encryption. Gets index after
  slash and reinsert @ char to index position"
  [^String obfuscated]
  (let [slash-index (.lastIndexOf obfuscated "/")]
    (if (< slash-index 0)
      (rot13 obfuscated)
      (let [sb    (StringBuilder. obfuscated)
            index (Integer/parseInt (.substring sb (inc slash-index)))]
        (-> (.substring sb 0 slash-index)
            (rot13)
            (StringBuilder.)
            (.replace index index "@")
            (str))))))


(comment
 (unobfuscate (obfuscate "example@test.com"))
 (unobfuscate "exampletest.com/7")
 )

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
