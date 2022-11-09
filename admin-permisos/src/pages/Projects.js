import React, { useState, useContext, useEffect } from "react";
import { store } from "../store.js";
import { Form, Row, Col, Button } from "react-bootstrap";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import IconButton from "@material-ui/core/IconButton";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";
import { PencilSquare, Trash } from "react-bootstrap-icons";
import { Redirect, useHistory } from "react-router-dom";

import { ProjectDelModal, ProjectAddModal } from "../components/index.js";

function createData(id, projectName, location, infomation) {
  return { id, projectName, location, infomation };
}

export function Projects({ match }) {
  const storeContext = useContext(store);
  let history = useHistory();
  const [initialRows, setInitialRows] = useState([]);
  const [rows, setRows] = useState([]);
  const [toggle, setToggle] = useState({
    delete: false,
    add: false,
  });
  const [curID, setCurID] = useState("");

  
  useEffect(() => {
    let indice = parseInt(localStorage.getItem("cantidad"));
    let datos  = [];
    for (let i = 1; i <= indice; i++) {
      
        datos.push(JSON.parse(localStorage.getItem(`permiso${i}`)))
    }
    setRows(datos)
  
   
  }, []);

  const toggleModal = (modal) => {
    let prevVal = toggle[modal];
    setToggle((prevState) => ({
      ...prevState,
      [modal]: !prevVal,
    }));
  };

  const activateModal = (projectID) => {
    setCurID(projectID);
    toggleModal("delete");
  };

  const edit = (projectID) => {
    history.push("/project/" + projectID);
  };

  const del = async (projectID) => {
    /*
    API for removing 
    */
    console.log(projectID);
    let curRows = rows;
    debugger;
    console.log(curRows.filter((row) => projectID !== row["indice"]));
    setInitialRows(curRows.filter((row) => projectID !== row["indice"]));
    setRows(curRows.filter((row) => projectID !== row["indice"]))
    localStorage.removeItem(`permiso${projectID}`)
    localStorage.setItem("cantidad",   parseInt(projectID)- 1)
    toggleModal("delete");
  };

  return (
    <div>
      <ProjectDelModal
        hide={toggle.delete}
        success={() => {
          del(curID);
        }}
        toggleModal={() => {
          toggleModal("delete");
        }}
      />{" "}
      <div className="content">
        <TableContainer>
          <Table aria-label="simple table">
            <TableHead>
              <TableRow>
                <TableCell>Nombre</TableCell>
                <TableCell align="left">Fecha</TableCell>
                <TableCell align="left">Grado</TableCell>
                <TableCell align="left">Motivo</TableCell>
                <TableCell align="right"></TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {rows.map((row) => (
                <TableRow key={row.indice}>
                  <TableCell component="th" scope="row">
                    {row.nombre}
                  </TableCell>
                  <TableCell align="left">{row.date}</TableCell>
                  <TableCell align="left">{row.grado}</TableCell>
                  <TableCell align="left">{row.motivo}</TableCell>
                  <TableCell align="right">
                    <IconButton onClick={() => edit(row.indice)}>
                      <PencilSquare
                        data-value={row.correo}
                        size={21}
                        color="royalblue"
                      />
                    </IconButton>
                    <IconButton onClick={() => activateModal(row.indice)}>
                      <Trash color="red" size={21} />
                    </IconButton>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </div>
    </div>
  );
}

export default { Projects };
