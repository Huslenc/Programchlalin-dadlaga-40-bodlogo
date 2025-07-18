#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);

vector<vector<int>> knightlOnAChessboard(int n) {
    vector<vector<int>> result(n-1, vector<int>(n-1, -1));
    
    for (int a = 1; a < n; ++a) {
        for (int b = 1; b < n; ++b) {
            if (result[b-1][a-1] != -1) {
                result[a-1][b-1] = result[b-1][a-1];
                continue;
            }
            
            queue<pair<int, int>> q;
            q.push({0, 0});
            
            vector<vector<int>> dist(n, vector<int>(n, -1));
            dist[0][0] = 0;
            
            int dx[] = {a, a, -a, -a, b, b, -b, -b};
            int dy[] = {b, -b, b, -b, a, -a, a, -a};
            
            while (!q.empty()) {
                auto current = q.front();
                q.pop();
                int x = current.first;
                int y = current.second;
                
                for (int k = 0; k < 8; ++k) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && dist[nx][ny] == -1) {
                        dist[nx][ny] = dist[x][y] + 1;
                        q.push({nx, ny});
                    }
                }
            }
            
            result[a-1][b-1] = dist[n-1][n-1];
        }
    }
    
    return result;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string n_temp;
    getline(cin, n_temp);

    int n = stoi(ltrim(rtrim(n_temp)));

    vector<vector<int>> result = knightlOnAChessboard(n);

    for (size_t i = 0; i < result.size(); i++) {
        for (size_t j = 0; j < result[i].size(); j++) {
            fout << result[i][j];

            if (j != result[i].size() - 1) {
                fout << " ";
            }
        }

        if (i != result.size() - 1) {
            fout << "\n";
        }
    }

    fout << "\n";

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}