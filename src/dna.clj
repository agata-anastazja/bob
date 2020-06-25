(ns dna
(:require [clojure.string :as str]))

(defn readComplement [s]
  ( let [dna_map {
            "G": "C"
            "C": "G"
            "T": "A"
            "A": "U"
          }
          's  ]
    (
      loop [  sList (seq s)
              acc ""]
      (if (empty? sList)
        acc
        (recur 
          (rest sList)
          (str/join acc ((str (first sList)) dna_map))
        )
    )     
          
          
  )

)