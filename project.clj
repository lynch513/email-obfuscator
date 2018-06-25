(defproject org.clojars.lynch/email-obfuscator "0.1.0-SNAPSHOT"
  :description "Clojure library for obfuscation e-mails. It combines some obfuscation technics"
  :url "git@github.com:lynch513/email-obfuscator.git"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot email-obfuscator.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
