const initialUser = JSON.parse(localStorage.getItem('user'));
const initialState = initialUser || null;

export const user = {
  state: {
    user:initialState,
  },

  getters: {
    USER: (state) => state.user,
  },

  mutations: {
    SET_USER: (state, payload) => {
      const userObj = {
        name: payload.name,
        email: payload.email,
        phone: payload.phone,
        password: payload.password,
        photo: payload.photo,
      };
      localStorage.setItem('user', JSON.stringify(userObj));
      state.user = userObj || null;
    },
  },

  actions: {
    GET_USER: (context, payload) => {
      context.commit('SET_USER', payload);
    },
  },
};