import React from "react";

export default function Input(props) {
  return (
    <input
      className="input"
      type={props.type}
      placeholder={props.placeholder}
      required={true}
      id={props.id}
      name={props.id}
      autoFocus={props.autoFocus == null ? false : true} // daha iyi yöntem?
      style={props.style}
      onChange={props.onChange ? props.onChange : () => {}}
    />
  );
}
