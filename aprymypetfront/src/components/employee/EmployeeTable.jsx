import React from "react";

const EmployeeTable = () => (
  <table>
    <thead>
      <tr>
        <th>ID BD</th>
        <th>first_name</th>
        <th>last_name</th>
        <th>email</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>ID BD</td>
        <td>first_name</td>
        <td>last_name</td>
        <td>email</td>
        <td>
          <button className="button muted-button">Edit</button>
          <button className="button muted-button">Delete</button>
        </td>
      </tr>
    </tbody>
  </table>
);

export default EmployeeTable;
