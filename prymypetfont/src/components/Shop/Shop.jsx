import React from "react";
import './Shop.scss';
import ShopTable from "./ShopTable";

const Shop = () => (
    <div className="Container">
    <h1>Registrar Tiendas</h1>
    <div className="flex-row">
      <div className="flex-large">
        <h2>Add Shop</h2>
        <form>
          <label>Nit</label>
          <input type="text" name="NIT_Shop" value="" />
          <label>Nombre</label>
          <input type="text" name="Shop_name" value="" />
          <label>Ubicación</label>
          <input type="text" name="Ubication" value="" />
          <button>Add new Shop</button>
        </form>
      </div>
      <div className="flex-large">
        <h2>View Shops</h2>
        <ShopTable />
      </div>
    </div>
  </div>
);
export default Shop;

