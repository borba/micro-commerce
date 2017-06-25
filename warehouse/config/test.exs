use Mix.Config

# We don't run a server during test. If one is required,
# you can enable the server option below.
config :warehouse, Warehouse.Endpoint,
  http: [port: 4001],
  server: false

# Print only warnings and errors during test
config :logger, level: :warn

# Configure your database
config :warehouse, Warehouse.Repo,
  adapter: Ecto.Adapters.Postgres,
  username: "postgres",
  password: "postgres",
  database: "warehouse_test",
  hostname: "192.168.99.100",
  pool: Ecto.Adapters.SQL.Sandbox
