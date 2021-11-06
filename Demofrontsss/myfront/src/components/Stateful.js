import React,{component, Component } from 'react';

class Stateful extends Component{
    constructor(props){
        super(props)
        this.state = {
            hello: 'Hello World'
        }
    }
    render(){
        return(
            <h2>{this.state.hello}</h2>
        )
    }
}

export default Stateful;