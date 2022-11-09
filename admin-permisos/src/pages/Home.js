import React, { useState } from "react";
import Button from "react-bootstrap/Button";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import InputGroup from "react-bootstrap/InputGroup";
import Row from "react-bootstrap/Row";
import { useHistory } from "react-router-dom";

export function Home() {
  const [validated, setValidated] = useState(false);
  const [date, setDate] = useState("");
  const [nombre, setNombre] = useState("");
  const [apellido, setApellido] = useState("");
  const [grado, setGrado] = useState("");
  const [celular, setCelular] = useState("");
  const [correo, setCorreo] = useState("");
  const [motivo, setMotivo] = useState("");
  const [estado, setEstado] = useState("pendiente");
  const [justificacion, setJustificacion] = useState("");
  let history = useHistory();
  const handleSubmit = (event) => {
    const form = event.currentTarget;
    if (form.checkValidity() === false) {
      event.preventDefault();
      event.stopPropagation();
    }

    setValidated(true);
  };

  const guardarPermiso = () => {
    console.log("aqasd");
    let indice = localStorage.getItem("cantidad");
    if (indice === null) {
      indice = 1;
    } else {
      indice = parseInt(indice) + 1;
    }
    localStorage.setItem("cantidad", indice);
    const permiso = {
      nombre,
      indice,
      apellido,
      date,
      motivo,
      grado,
      celular,
      grado,
      motivo,
      justificacion,
      estado,
      correo,
    };

    localStorage.setItem(`permiso${indice}`, JSON.stringify(permiso));
    history.push("/ver_permisos");
  };
  return (
    <>
      <div className="d-flex justify-content-center p-5">
        <h1>Solicitar Permiso</h1>
        <hr />
      </div>
      <div className="d-flex justify-content-center p-5">
        <Form noValidate validated={validated} onSubmit={handleSubmit}>
          <Row className="mb-3">
            <Form.Group as={Col} md="3" controlId="validationCustom01">
              <Form.Label>Nombre Estudiante</Form.Label>
              <Form.Control
                required
                type="text"
                placeholder="Nombre"
                onChange={(e) => setNombre(e.target.value)}
              />
            </Form.Group>
            <Form.Group as={Col} md="3" controlId="validationCustom02">
              <Form.Label>Apellido Estudiante </Form.Label>
              <Form.Control
                required
                type="text"
                placeholder="Apellido"
                onChange={(e) => setApellido(e.target.value)}
              />
              <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
            </Form.Group>
            <Form.Group as={Col} md="3" controlId="validationCustom02">
              <Form.Label>Grado estudiante </Form.Label>
              <Form.Control
                required
                type="text"
                placeholder="Grado"
                onChange={(e) => setGrado(e.target.value)}
              />
              <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
            </Form.Group>
            <Form.Group as={Col} md="3" controlId="validationCustom02">
              <Form.Label>Celular Acudiente</Form.Label>
              <Form.Control
                required
                type="text"
                placeholder="Celular"
                onChange={(e) => setCelular(e.target.value)}
              />
              <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
            </Form.Group>
            <Form.Group as={Col} md="3" controlId="validationCustomUsername">
              <Form.Label>Correo</Form.Label>
              <InputGroup hasValidation>
                <InputGroup.Text id="inputGroupPrepend">@</InputGroup.Text>
                <Form.Control
                  type="text"
                  placeholder="Correo"
                  aria-describedby="inputGroupPrepend"
                  required
                  onChange={(e) => setCorreo(e.target.value)}
                />
                <Form.Control.Feedback type="invalid">
                  Please choose a username.
                </Form.Control.Feedback>
              </InputGroup>
            </Form.Group>
            <Form.Group as={Col} md="2" controlId="validationCustom02">
              <Form.Label>Fecha del Permiso</Form.Label>
              <Form.Control
                type="date"
                onChange={(e) => setDate(e.target.value)}
                rows={3}
              />
            </Form.Group>
            <Form.Group as={Col} md="4" controlId="validationCustom02">
              <Form.Label>Motivo </Form.Label>
              <Form.Control
                required
                type="text"
                onChange={(e) => setMotivo(e.target.value)}
              />
              <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
            </Form.Group>
          </Row>

          <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
            <Form.Label>justificacion</Form.Label>
            <Form.Control
              as="textarea"
              rows={3}
              onChange={(e) => setJustificacion(e.target.value)}
            />
          </Form.Group>

          <Button onClick={guardarPermiso}>Solicitar</Button>
        </Form>
      </div>
    </>
  );
}

export default { Home };
