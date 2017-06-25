defmodule Warehouse.Repo.Migrations.CreateProduct do
  use Ecto.Migration

  def change do
    create table(:products, primary_key: false) do
      add :id, :binary_id, primary_key: true
      add :code, :string
      add :description, :string

      timestamps()
    end

  end
end
