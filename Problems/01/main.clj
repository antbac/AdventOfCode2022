(require 'clojure.string)

(defn Main
  "Returns the number of calories the Elf carrying the most calories is carrying"
  [file]
  (as->
   (slurp file) result
   (clojure.string/split result #"\n\n")
   (map
    (fn [elf]
      (reduce
       +
       (map
        (fn [item] (Integer/parseInt item))
        (clojure.string/split elf #"\n"))))
    result)
   (apply max result)
   (println result)))

(Main "./input.txt")