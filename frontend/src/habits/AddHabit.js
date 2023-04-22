import React, { useState } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";

export default function AddHabit() {
  const [habit, setHabit] = useState({
    name: "",
    monday: false,
    tuesday: false,
    wednesday: false,
    thursday: false,
    friday: false,
    saturday: false,
    sunday: false,
  });

  const {
    name,
    monday,
    tuesday,
    wednesday,
    thursday,
    friday,
    saturday,
    sunday,
  } = habit;

  const onInputChange = (e) => {
    setHabit({ ...habit, [e.target.name]: e.target.value });
  };

  let navigate = useNavigate();

  const onSubmit = async (e) => {
    e.preventDefault();
    console.log(habit);

    await axios
      .post("http://localhost:8080/habit", habit)
      .then((response) => console.log(response));

    navigate("/");
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 boder rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Add Habit</h2>
          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Name:
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter new habit name"
                name="name"
                value={name}
                onChange={(e) => onInputChange(e)}
              />
            </div>

            <button type="submit" className="btn btn-primary">
              Submit
            </button>
            <Link className="btn btn-outline-danger mx-2" to="/">
              Cancel
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}
