defmodule Warehouse.Router do
  use Warehouse.Web, :router

  pipeline :api do
    plug :accepts, ["json"]
  end

  scope "/api", Warehouse do
    pipe_through :api
  end
end
