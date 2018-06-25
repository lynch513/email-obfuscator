(ns email-obfuscator.rot13)
;; Original code https://gist.github.com/jongukim/6825357

(defn- shift13 [start n]
  (let [s (int start)
        c (int n)]
    (char (if (<= s c (+ s 25))
            (+ s (mod (+ (- c s) 13) 26))
            n))))

(defn rot13 
  "Gets the string encode it using rot13 encryption and returns it"
  [st]
  (->> (map (fn [x]
              (let [n (int x)]
                (cond
                  (<= 65 n 90) (shift13 \A x)
                  (<= 97 n 122) (shift13 \a x)
                  :else x)))
            (seq st))
       (apply str)))

