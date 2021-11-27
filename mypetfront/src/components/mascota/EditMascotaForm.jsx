import React, { useState, useEffect } from "react";

const EditMascotaForm = (props) => {
  const [mascota, setMascota] = useState(props.currentMascota);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setMascota({ ...mascota, [name]: value });
  };

  useEffect(() => {
    setMascota(props.currentMascota);
  }, [props]);

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        props.updateMascota(mascota.id, mascota);
      }}
    >
      <label>Nombre Mascota</label>
      <input
        type="text"
        name="nombreMascota"
        value={mascota.nombreMascota}
        onChange={handleInputChange}
      />

      <button>Actualizar Mascota</button>
      <button
        onClick={() => props.setEditing(false)}
        className="button muted-button"
      >
        Cancel
      </button>
    </form>
  );
};

export default EditMascotaForm;

