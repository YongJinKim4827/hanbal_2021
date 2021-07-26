import React from "react";
import PropTypes from "prop-types";

class App extends React.Component{
  //function이 아니기 때문에 Return이 없음
  //React는 자동적으로 Class Component의 render method를 자동으로 실행함
  
  //State를 직접 변경해서는 안됨
  //setState를 호출할때 마다 react는 새로운 State와 함께 render function을 호출
  state = { //바꾸고 싶은 data를 넣음
    isLoading : true,
    movies : []
  }

  componentDidMount(){
    setTimeout(()=> {
      this.setState({isLoading : false})
    }, 6000)
  }
  render(){
    const {isLoading} = this.state;

    return <div>{isLoading ?  "Loading" : "We are Ready"}</div>

  }
}

export default App;
