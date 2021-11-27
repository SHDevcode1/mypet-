import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import reportWebVitals from './reportWebVitals';

import Stateles from './components/Stateless'
import Statelesful from './components/Stateful'
import PresentacionalConstantes from './components/PresentacionalConstantes'
import Button1 from './components/Button1'
import Button from './components/Button'
import GetGreeting from './components/GetGreeting'


ReactDOM.render(
  <React.StrictMode>
    <Stateles />
    <Statelesful />
    <PresentacionalConstantes />
    <Button1 text="Click hola mundo" />
    <Button1 text="Click2 hola mundo2" />
    <Button /> 
    <GetGreeting />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();