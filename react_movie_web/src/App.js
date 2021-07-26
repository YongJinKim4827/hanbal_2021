import React from "react";
import PropTypes from "prop-types";
import axios from "axios";
import Movie from "./Movies";
import "./App.css";

class App extends React.Component{
  //function이 아니기 때문에 Return이 없음
  //React는 자동적으로 Class Component의 render method를 자동으로 실행함
  
  //State를 직접 변경해서는 안됨
  //setState를 호출할때 마다 react는 새로운 State와 함께 render function을 호출
  state = { //바꾸고 싶은 data를 넣음
    isLoading : true,
    movies : []
  }

  getMovies = async() => {
    const {
      data : {
        data : {
           movies
          }
        }
      } = await axios.get(
        "https://yts-proxy.nomadcoders1.now.sh/list_movies.json?sort_by=rating");
      this.setState({movies, isLoading :false})
    }

  componentDidMount(){
    this.getMovies();
  }

  render(){
    const { isLoading, movies } = this.state;
    return <section className="container">
      {isLoading ? (<div className="loader">
        <span className="loader__text">Loading...</span>
      </div> )
      : 
      (<div className="movies">
        {
          movies.map(movie => {
            return <Movie key = {movie.id} id={movie.id} year={movie.year} title={movie.title} summary={movie.summary} poster={movie.large_cover_image} genres={movie.genres}/>
              })
        }
      </div>
        )}
        </section>

  }
}

export default App;
