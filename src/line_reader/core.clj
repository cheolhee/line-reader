(ns line-reader.core
  (:import (java.io BufferedReader))
  (:gen-class)
  )

(defn default-line-handler [ln c]
  (println (str c ":" ln))
  )

(defn read-lines [line-handler-fn]
  (doseq [[ln c]
          (map list
               (line-seq (BufferedReader. *in*))
               (drop 1 (range)))]
    (line-handler-fn ln c))
  )

(defn -main
  ([]
   (read-lines default-line-handler))
  ([f]
   (read-lines (load-string f))) ; eval 실패하면 그대로 종료.
  )
