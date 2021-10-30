import React from 'react';

import { BrowserRouter, Switch, Route } from "react-router-dom";
import Layout from "../containers/LayoutPrincipal/LayoutPrincipal";
import Home from "../components/home/Home";
import Employee from "../components/employee/Employee";
import NoFound from "../components/notfound/NoFound";


const AppRoutes = () => {
    <BrowserRouter>
        <Layout>
            <Switch>
                <Route exact path="/" component = {Home} />
                <Route exact path="/Employee" component = {Employee} />
                <Route component = {NoFound} />
            </Switch>
        </Layout>
    </BrowserRouter>
}
export default AppRoutes;