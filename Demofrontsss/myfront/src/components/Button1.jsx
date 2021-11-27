import React from 'react';



const Button1 = props => {
    const { text } = props;
    return (
        <div>
            <button type="botón">{props.text}</button>
         
        </div>
    )
};

export default Button1