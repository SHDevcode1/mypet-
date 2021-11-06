import React from "react";

const ShopTable = (props) => (
  <table>
    <thead>
      <tr>
        <th>ID BD</th>
        <th>firstName</th>
        <th>lastName</th>
        <th>email</th>
      </tr>
    </thead>
    <tbody>
      {undefined !== props.shops && props.shops.length > 0 ? (
        props.shops.map((shop) => (
          <tr key={shop.id.toString()}>
            <td>{shop.id}</td>
            <td>{shop.firstName}</td>
            <td>{shop.lastName}</td>
            <td>{shop.email}</td>
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
                onClick={() => props.deleteShop(shop.id)}
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

