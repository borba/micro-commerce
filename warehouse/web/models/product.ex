defmodule Warehouse.Product do
  use Warehouse.Web, :model

  schema "products" do
    field :code, :string
    field :description, :string

    timestamps()
  end

  @doc """
  Builds a changeset based on the `struct` and `params`.
  """
  def changeset(struct, params \\ %{}) do
    struct
    |> cast(params, [:code, :description])
    |> validate_required([:code, :description])
  end
end
