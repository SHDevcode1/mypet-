import React, { useState, useEffect } from "react";
import "./Shop.scss";
import ShopTable from "./ShopTable";
import AddShopForm from "./AddShopForm";
import EditShopForm from "./EditShopForm";
import axios from "axios";

const Shop = () => {
  const ShopData = [
    { nit_Shop: 1, NameShop: "pet_shop", city: "Medellín", ubication: "Cra 42 " },
    { nit_Shop: 2, NameShop: "Shopispets", city: "Rio Negro", ubication: "Cra 43" },
    { nit_Shop: 3, NameShop: "Lunchispet", city: "Manizales", ubication: "Cra 44" },
  ];
  const [shops, setShops] = useState(ShopData);
  const [showLoading, setShowLoading] = useState(true);
  const apiUrl = "http://localhost:8282/shopAPI/";

  useEffect(() => {
    const fetchData = async () => {
      const result = await axios(apiUrl + "shopgetall");
      setShops(result.data.shopList);
    };
    fetchData();
  }, []);



  const addShop = (shop) => {
    setShowLoading(true);
    const data = {
      nit_Shop: shop.nit_Shop,
      NameShop: shop.NameShop,
      city: shop.city,
      ubication: shop.ubication,
    };
    axios
      .post(apiUrl + "addshop", data)
      .then((result) => {
        setShops([...shops, result.data]);
      })
      .catch((error) => setShowLoading(false));

    /*
    shop.nit_Shop = shops.length + 1;
    setShops([...shops, shop]);

    const data = {
      nit_Shop: parseInt(shop.nit_Shop),
      NameShop: shop.NameShop,
      city: shop.city,
      ubication: shop.ubication,
    };

    axios
      .post(apiUrl, data)
      .then((result) => {
        //props.history.push('/show/' + result.data._nit_Shop)
        console.log("Consumo del Servicio 2");
        console.log(result);
      })
      .catch((error) => setShowLoading(false));
*/
  };

  const deleteShop = (nit_Shop) => {
    setShops(shops.filter((shop) => shop.nit_Shop !== nit_Shop));
    const data = {
      nit_Shop: nit_Shop,
      NameShop: "",
      city: "",
      ubication: "",
    };
    axios
      .post(apiUrl + "shopremove", data)
      .then((result) => {
        //console.log(result);
      })
      .catch((error) => setShowLoading(false));
  };

  const [editing, setEditing] = useState(false);

  const initialFormState = {
    nit_Shop: null,
    NameShop: "",
    city: "",
    ubication: "",
  };

  const [currentShop, setCurrentShop] = useState(initialFormState);

  const editRow = (shop) => {
    setEditing(true);
    setCurrentShop({
      nit_Shop: shop.nit_Shop,
      NameShop: shop.NameShop,
      city: shop.city,
      ubication: shop.ubication,
    });
  };

  const updateShop = (nit_Shop, updatedShop) => {
    setEditing(false);
    setShops(
      shops.map((shop) =>
        shop.nit_Shop === nit_Shop ? updatedShop : shop
      )
    );
    const data = {
      nit_Shop: updatedShop.nit_Shop,
      NameShop: updatedShop.NameShop,
      city: updatedShop.city,
      ubication: updatedShop.ubication,
    };
    axios
      .post(apiUrl + "updateshop", data)
      .then((result) => {
        //console.log("Updated");
      })
      .catch((error) => setShowLoading(false));
  };

  return (
    <div className="container">
      <h1>CRUD App with Hooks</h1>
      <div className="flex-row">
        <div className="flex-large">
          {editing ? (
            <div>
              <h2>Edit Shop</h2>
              <EditShopForm
                setEditing={setEditing}
                currentShop={currentShop}
                updateShop={updateShop}
              />
            </div>
          ) : (
            <div>
              <h2>Add shop</h2>
              <AddShopForm addShop={addShop} />
            </div>
          )}
        </div>

        <div className="flex-large">
          <h2>View Shops</h2>
          <ShopTable
            shops={shops}
            deleteShop={deleteShop}
            editRow={editRow}
          />
        </div>
      </div>
    </div>
  ); 
};

export default Shop;
