import React from "react";

import { BrowserRouter, Switch, Route } from "react-router-dom";

import Layout from "../containers/layoutprincipal/LayoutPrincipal";
import Home from "../components/home/Home";
import Customer from "../components/customer/Customer";
import NotFound from "../components/notfound/NotFound";

export default function AppRoutes(){
    return(
    <Router>
        <Layout>
            <Switch>
                <Route exact path="/" component={home} />
                <Route exact path="/Home" component={home} />
                <Route exact path="/Customer" component={Customer} />
                <Route component={NotFound} />
            </Switch>
        </Layout>
    </Router>
    );
}