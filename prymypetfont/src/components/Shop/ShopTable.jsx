import React from "react";

const ShopTable = (props) => (
  <table>
    <thead>
      <tr>
        <th>NIT_Shop</th>
        <th>ShopName</th>
        <th>City</th>
        <th>Ubication</th>
      </tr>
    </thead>
    <tbody>
      {undefined !== props.shops && props.shops.length > 0 ? (
        props.shops.map((shop) => (
          <tr key={shop.nit_Shop.toString()}>
            <td>{shop.nit_Shop}</td>
            <td>{shop.shopName}</td>
            <td>{shop.city}</td>
            <td>{shop.ubication}</td>
            <td>
              <button
                onClick={() => {
                  props.editRow(shop);
                }}
                className="button muted-button"
              >
                Edit
              </button>
              <button
                onClick={() => props.deleteShop(shop.nit_Shop)}
                className="button muted-button"
              >
                Delete
              </button>
            </td>
          </tr>
        ))
      ) : (
        <tr>
          <td colSpan={3}>No shop</td>
        </tr>
      )}
    </tbody>
  </table>
);

export default ShopTable;

