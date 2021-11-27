import React, { useState, useEffect } from "react";

const EditShopForm = (props) => {
  const [shop, setShop] = useState(props.currentShop);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setShop({ ...shop, [name]: value });
  };

  useEffect(() => {
    setShop(props.currentShop);
  }, [props]);

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        props.updateShop(shop.nit_Shop, shop);
      }}
    >
      <label>Nombre de Tienda</label>
      <input
        type="text"
        name="NameShop"
        value={shop.name}
        onChange={handleInputChange}
      />
      <label>Ciudad</label>
      <input
        type="text"
        name="city"
        value={shop.city}
        onChange={handleInputChange}
      />

      <label>Ubicación</label>
      <input
        type="text"
        name="ubication"
        value={shop.ubication}
        onChange={handleInputChange}
      />

      <button>Update shop</button>
      <button
        onClick={() => props.setEditing(false)}
        className="button muted-button"
      >
        Cancel
      </button>
    </form>
  );
};

export default EditShopForm;
