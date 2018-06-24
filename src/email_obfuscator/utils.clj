(ns email-obfuscator.utils)
;; Original code for escape-html
;;   https://github.com/weavejester/hiccup/blob/master/src/hiccup/util.clj
;; I use simplicity version

(defn escape-html
  "Change special characters into HTML character entities."
  [^String st]
  (.. st
    (replace "&"  "&amp;")
    (replace "<"  "&lt;")
    (replace ">"  "&gt;")
    (replace "\"" "&quot;")
    (replace "'"  "&apos;")))

