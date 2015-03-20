(ns mailgun-clj.config)

(def credentials {:api-key ""
                  :public-api-key ""
                  :domain ""})

(def api-key (:api-key credentials))
(def public-api-key (:public-api-key credentials))
(def domain (:domain credentials))
