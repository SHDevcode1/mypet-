import React, { useState, useEffect } from "react";
import "./Mascota.scss";
import MascotaTable from "./MascotaTable";
import AddMascotaForm from "./AddMascotaForm";
import EditMascotaForm from "./EditMascotaForm";
import axios from "axios";

const Mascota = () => {
  const MascotaData = [
    { id: 1, nombreMascota: "Juan"},
    { id: 2, nombreMascota: "Perez"},
    { id: 3, nombreMascota: "guerra"},
  ];
  const [mascota, setMascotas] = useState(MascotaData);
  const [showLoading, setShowLoading] = useState(true);
  const apiUrl = "http://localhost:8080/api/mascotaCustomAPI";

  useEffect(() => {
    const fetchData = async () => {
      const result = await axios(apiUrl + "mascotasgetall");
      setMascotas(result.data.mascotaList);
    }; 
    fetchData();
  }, []);



  const addMascota = (mascota) => {
    setShowLoading(true);
    const data = {
      id: mascota.id,
      nombreMascota: mascota.nombreMascota
    };
    axios
      .post(apiUrl + "addmascota", data)
      .then((result) => {
        setMascotas([...mascotas, result.data]);
      })
      .catch((error) => setShowLoading(false));

    /*
    employee.id = employees.length + 1;
    setEmployees([...employees, employee]);

    const data = {
      id: parseInt(employee.id),
      firstName: employee.firstName,
      lastName: employee.lastName,
      email: employee.email,
    };

    axios
      .post(apiUrl, data)
      .then((result) => {
        //props.history.push('/show/' + result.data._id)
        console.log("Consumo del Servicio 2");
        console.log(result);
      })
      .catch((error) => setShowLoading(false));
*/
  };

  const deleteMascota = (id) => {
    setMascotas(mascota.filter((mascota) => mascota.id !== id));
    const data = {
      id: id,
      nombreMascota: ""
    };
    axios
      .post(apiUrl + "mascotaremove", data)
      .then((result) => {
        //console.log(result);
      })
      .catch((error) => setShowLoading(false));
  };

  const [editing, setEditing] = useState(false);

  const initialFormState = {
    id: null,
    nombreMascota: ""
  };

  const [currentMascota, setCurrentMascota] = useState(initialFormState);

  const editRow = (mascota) => {
    setEditing(true);
    setCurrentMascota({
      id: mascota.id,
      nombreMascota: mascota.nombreMascota,
    });
  };

  const updateMascota = (id, updatedMascota) => {
    setEditing(false);
    setMascotas(
      mascotas.map((mascota) =>
        mascota.id === id ? updatedMascota : mascota
      )
    );
    const data = {
      id: updatedMascota.id,
      nombreMascota: updatedMascota.nombreMascota,
    };
    axios
      .post(apiUrl + "updatemascota", data)
      .then((result) => {
        console.log("Updated");
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
              <h2>Editar Mascota</h2>
              <EditMascotaForm
                setEditing={setEditing}
                currentMascota={currentMascota}
                updateMascota={updateMascota}
              />
            </div>
          ) : (
            <div>
              <h2>Adicionar Mascota</h2>
              <AddMascotaForm addMascota={addMascota} />
            </div>
          )}
        </div>

        <div className="flex-large">
          <h2>Ver Mascota</h2>
          <MascotaTable
            mascotas={mascota}
            deleteMascota={deleteMascota}
            editRow={editRow}
          />
        </div>
      </div>
    </div>
  );
};

export default Mascota;



