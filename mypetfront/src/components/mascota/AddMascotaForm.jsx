import React, { useState } from "react";
import Mascota from "./Mascota";

const AddMascotaForm = (props) => {

const initialFormState = { id: null, nombreMascota: ""};
const [mascota, setMascota] = useState(initialFormState);

const handleInputChange = (event) => {
  const { name, value } = event.target;
        //console.log(event);
  setEmployee({ ...mascota, [name]: value });
};

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        if (!mascota.nombreMascota)
          return;

        props.addMascota(Mascota);
        setMascota(initialFormState);
      }}
    >
      <label>Nombre Mascota</label>
      <input
        type="text"
        name="nombreMascota"
        value={mascota.nombreMascota}
        onChange={handleInputChange}
      />
    
      <button>Adicionar Nueva Mascota</button>
    </form>
  );
};
export default AddMascotaForm;

