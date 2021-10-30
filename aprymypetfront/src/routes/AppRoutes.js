import React from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import Layout from "../containers/LayoutPrincipal/LayoutPrincipal";
import Home from "../components/home/Home";
//import Employee from "../components/employee/Employee";
//import NoFound from "../components/notfound/NoFound";

export default function AppRoutes() {
    return (
    <Router>
        <Layout>
            <Switch>
                <Route path="/" component = {Home} />
            </Switch>
        </Layout>
    </Router>
    );
}
