import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";

export default function Home() {
  const [habits, setHabits] = useState([]);

  useEffect(() => {
    loadHabits();
  }, []);

  async function loadHabits() {
    const result = await axios.get("http://localhost:8080/habits");
    setHabits(result.data);
  }

  const { id } = useParams();

  const deleteHabit = async (id) => {
    await axios.delete(`http://localhost:8080/habit/${id}`);
    loadHabits();
  };

  return (
    <div className="container">
      <div className="py-4">
        <table className="table border shadow">
          <thead>
            <tr>
              {/* <th scope="col" className="col-1">
                #
              </th> */}
              <th scope="col" className="col-5">
                Name
              </th>
              <th scope="col" className="col-.5">
                Monday
              </th>
              <th scope="col" className="col-.5">
                Tuesday
              </th>
              <th scope="col" className="col-.5">
                Wednesday
              </th>
              <th scope="col" className="col-.5">
                Thursday
              </th>
              <th scope="col" className="col-.5">
                Friday
              </th>
              <th scope="col" className="col-.5">
                Saturday
              </th>
              <th scope="col" className="col-.5">
                Sunday
              </th>
              <th scope="col" className="col-2">
                Actions
              </th>
            </tr>
          </thead>
          <tbody>
            {habits.map((habit) => (
              <tr key={habit.id}>
                <td>{habit.name}</td>
                <td>
                  <input type="checkbox" />
                </td>
                <td>
                  <input type="checkbox" />
                </td>
                <td>
                  <input type="checkbox" />
                </td>
                <td>
                  <input type="checkbox" />
                </td>
                <td>
                  <input type="checkbox" />
                </td>
                <td>
                  <input type="checkbox" />
                </td>
                <td>
                  <input type="checkbox" />
                </td>
                {/* <td>{habit.monday}</td>
                <td>{habit.tuesday}</td>
                <td>{habit.wednesday}</td>
                <td>{habit.thursday}</td>
                <td>{habit.friday}</td>
                <td>{habit.saturday}</td>
                <td>{habit.sunday}</td> */}
                <td>
                  {/* <Link
                    className="btn btn-primary mx-1"
                    to={`/viewhabit/${habit.id}`}
                  >
                    View
                  </Link> */}
                  <Link
                    className="btn btn-outline-primary mx-1"
                    to={`/edithabit/${habit.id}`}
                  >
                    Edit
                  </Link>
                  <button
                    className="btn btn-danger mx-1"
                    onClick={() => deleteHabit(habit.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <Link className="btn btn-outline-primary my-2" to="/addhabit">
        Add New Habit
      </Link>
    </div>
  );
}
