import React, { useState } from "react";

const AddShopForm = (props) => {

const initialFormState = { nit_Shop: null, NameShop: "", city: "" , ubication: ""};
const [shop, setShop] = useState(initialFormState);

const handleInputChange = (event) => {
  const { name, value } = event.target;
        //console.log(event);
  setShop({ ...shop, [name]: value });
};

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        if (!shop.NameShop || !shop.city || !shop.ubication)
          return;

        props.addShop(shop);
        setShop(initialFormState);
      }}
    >
      <label>Nombre de tienda: </label>
      <input
        type="text"
        name="NameShop"
        value={shop.NameShop}
        onChange={handleInputChange}
      />
      <label>Ciudad: </label>
      <input
        type="text"
        name="city"
        value={shop.city}
        onChange={handleInputChange}
      />

      <label>Ubicación: </label>
      <input
        type="text"
        name="ubication"
        value={shop.ubication}
        onChange={handleInputChange}
      />
      <button>Agregar tienda</button>
    </form>
  );
};
export default AddShopForm;
