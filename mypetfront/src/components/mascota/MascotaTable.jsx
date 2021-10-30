import React from "react";

const MascotaTable = (props) => (
  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Nombre Mascota</th>
      </tr>
    </thead>
    <tbody>
      {undefined !== props.mascotas && props.mascotas.length > 0 ? (
        props.mascotas.map((mascota) => (
          <tr key={mascota.id.toString()}>
            <td>{mascota.id}</td>
            <td>{mascota.nombreMascota}</td>
            <td>
              <button
                onClick={() => {
                  props.editRow(mascota);
                }}
                className="button muted-button"
              >
                Edit
              </button>
              <button
                onClick={() => props.deleteMascota(mascota.id)}
                className="button muted-button"
              >
                Delete
              </button>
            </td>
          </tr>
        ))
      ) : (
        <tr>
          <td colSpan={3}>No Mascota</td>
        </tr>
      )}
    </tbody>
  </table>
);

export default MascotaTable;

