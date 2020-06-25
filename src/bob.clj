(ns bob
  (:require [clojure.string :as str]))

(defn yell? [s]
  (some? (re-matches #"[^a-z]*[A-Z][^a-z]*" s)))

(defn question? [s]
  (str/ends-with? (str/trimr s) "?"))

(defn response-for [s]
  (if (str/blank? s) "Fine. Be that way!"
    (case [(question? s) (yell? s)]
      [true  true ] "Calm down, I know what I'm doing!"
      [true  false] "Sure."
      [false true ] "Whoa, chill out!"
      [false false] "Whatever.")))
  


