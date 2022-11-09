import React, { useContext } from "react";
import { store } from "./store.js";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "./styles.css";
import { NavBar } from "./components/index.js";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Redirect
} from "react-router-dom";


import { Home, Login, Projects, EditProject, Aprobar_permiso, Solicitud } from "./pages/index.js";

class DebugRouter extends Router {
  constructor(props) {
    super(props);
    console.log("initial history is: ", JSON.stringify(this.history, null, 2));
    this.history.listen((location, action) => {
      console.log(
        `The current URL is ${location.pathname}${location.search}${location.hash}`
      );
      console.log(
        `The last navigation action was ${action}`,
        JSON.stringify(this.history, null, 2)
      );
    });
  }
}

export function App() {
  return (
    // <DebugRouter>
    <Router>
      <Switch>
        <PrivateRoute path="/soliciar_permiso">
          <Home />
        </PrivateRoute>
        <PrivateRoute path="/project/:projectId">
          <EditProject />
        </PrivateRoute>
        
        <PrivateRoute path="/aprobar_permisos">
          <Aprobar_permiso/>
        </PrivateRoute>
        <PrivateRoute path="/solicitud/:projectId">
          <Solicitud/>
        </PrivateRoute>
        
        
        <PrivateRoute path="/ver_permisos">
          <Projects />
        </PrivateRoute>
        <PublicRoute path="/">
          <Login />
        </PublicRoute>
      </Switch>
    </Router>
    // </DebugRouter>
  );
}

function PrivateRoute({ children, ...rest }) {
  const storeContext = useContext(store);
  const globalState = storeContext.state;
  let auth = globalState.auth;
  return (
    <Route
      {...rest}
      render={(props) =>
        auth ? (
          <div className="h-100">
            <NavBar />
            <div id="content-body">
              {React.cloneElement(children, { params: props.match.params })}
            </div>
          </div>
        ) : (
          <Redirect
            to={{
              pathname: "/",
              state: { from: props.location }
            }}
          />
        )
      }
    />
  );
}

function PublicRoute({ children, ...rest }) {
  const storeContext = useContext(store);
  const globalState = storeContext.state;
  let auth = globalState.auth;
  return (
    <Route
      {...rest}
      render={({ location }) =>
        auth ? (
          <Redirect
            to={{
              pathname: "/project/temp",
              state: { from: location }
            }}
          />
        ) : (
          children
        )
      }
    />
  );
}

export default App;
