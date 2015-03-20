(ns mailgun-clj.api
  (:require [mailgun-clj.config :as config]))

(def endpoints
  {:api-base                  "https://api.mailgun.net/v3"
   :messages-endpoint         "messages"
   :mime-messages-endpoint    "messages.mime"
   :address-validate-endpoint "address/validate"
   :address-parse-endpoint    "address/parse"
   :bounces-endpoint          "bounces"
   :stats-endpoint            "stats"
   :domains-endpoint          "domains"
   :delete-tag-endpoint       "tags"
   :campaigns-endpoint        "campaigns"
   :events-endpoint           "events"
   :credentials-endpoint      "credentials"
   :unsubscribes-endpoint     "unsubscribes"
   :routes-endpoint           "routes"
   :webhooks-endpoint         "webhooks"
   :lists-endpoint            "lists"
   :basic-auth-user           "api"})

(def authorization  {:basic-auth [(:basic-auth-user endpoints) (:api-key config/credentials)]})

(defn api-url
  [endpoint]
  (format "%s/%s/%s" (:api-base endpoints) (:domain config/credentials) endpoint))

(defn domain-api-url
  [endpoint]
  (format "%s/domains/%s/%s" (:api-base endpoints) (:domain config/credentials) endpoint))

(defn public-api-url
  [endpoint]
  (format "%s/%s" (:api-base endpoints) endpoint))

(defn credentials-url
  [id]
  (domain-api-url (format "%s/%s" (:credentials-endpoint endpoints) id)))
