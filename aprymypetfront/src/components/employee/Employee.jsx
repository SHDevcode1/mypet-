import React from "react";
import "./Employee.scss";
import EmployeeTable from "./EmployeeTable";

const Employee = () => (
  <div className="container">
    <h1>CRUD App with Hooks</h1>
    <div className="flex-row">
      <div className="flex-large">
        <h2>Add Employee</h2>
        <form>
          <label>First Name</label>
          <input type="text" name="firstName" value="" />
          <label>Username</label>
          <input type="text" name="lastName" value="" />
          <label>email</label>
          <input type="text" name="email" value="" />
          <button>Add new employee</button>
        </form>
      </div>
      <div className="flex-large">
        <h2>View Employees</h2>
        <EmployeeTable />
      </div>
    </div>
  </div>
);
export default Employee;
