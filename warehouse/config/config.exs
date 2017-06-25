# This file is responsible for configuring your application
# and its dependencies with the aid of the Mix.Config module.
#
# This configuration file is loaded before any dependency and
# is restricted to this project.
use Mix.Config

# General application configuration
config :warehouse,
  ecto_repos: [Warehouse.Repo]

# Configures the endpoint
config :warehouse, Warehouse.Endpoint,
  url: [host: "localhost"],
  secret_key_base: "3rtL19T0MxUoP+lTQ4nor8ukyQtAJeFCWybjB57ETrKcDIG5HeIZSpJFPGQMrHHs",
  render_errors: [view: Warehouse.ErrorView, accepts: ~w(json)],
  pubsub: [name: Warehouse.PubSub,
           adapter: Phoenix.PubSub.PG2]

# Configures Elixir's Logger
config :logger, :console,
  format: "$time $metadata[$level] $message\n",
  metadata: [:request_id]

# Configure phoenix generators
config :phoenix, :generators,
  binary_id: true

# Configures Kafka_Ex
config :kafka_ex,
  brokers: [{"192.168.99.100", 9092}],
  consumer_group: "warehouse",
  disable_default_worker: false,
  use_ssl: false,
  kafka_version: "0.10.2"

# Import environment specific config. This must remain at the bottom
# of this file so it overrides the configuration defined above.
import_config "#{Mix.env}.exs"
